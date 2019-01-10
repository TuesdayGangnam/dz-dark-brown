import com.dz.ApiApplication
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.boot.json.JacksonJsonParser
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

import static io.restassured.RestAssured.given
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration

@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest extends Specification {

    /**
     * 자동 생성될 문서들의 Root 디렉토리를 지정합니다.
     * 기본값으로 Maven은 target/generated-snippets, Gradle은 build/generated-snippets으로 지정되어있습니다.
     * 각 문서들은 위 설정된 Root 디렉토리의 하위 디렉토리에 자동생성됩니다.
     */
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation()

    private RequestSpecification spec

    @LocalServerPort
    private int port

    //@before
    def setup() {
        this.spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(this.restDocumentation))
                .build()
    }

    def "access_Token 값 가져오기"()

    {
        expect:
        given(this.spec)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .filter(document("users",
                requestHeaders(
                        headerWithName("Content-Type").description("Content Type"),
                        headerWithName("Authorization").description("client id, client password 조합")
                ),
                requestParameters(
                        parameterWithName("username").description("username"),
                        parameterWithName("password").description("password"),
                        parameterWithName("grant_type").description("grant_type")
                ),
                responseFields(
                        fieldWithPath("access_token").type(JsonFieldType.STRING).description("access_token"),
                        fieldWithPath("token_type").type(JsonFieldType.STRING).description("token_type"),
                        fieldWithPath("refresh_token").type(JsonFieldType.STRING).description("refresh_token"),
                        fieldWithPath("expires_in").type(JsonFieldType.NUMBER).description("user password"),
                        fieldWithPath("scope").type(JsonFieldType.STRING).description("scope")
                )
                ))
                .header("Content-Type", ContentType.URLENC)
                .header("Authorization", "Basic dGVzdDoxMjM0")
                .formParam("username", "jihoon")
                .formParam("password", "pass")
                .formParam("grant_type", "password")
                .when().port(this.port).post("/oauth/token")
                .then().assertThat().statusCode(200)

    }

    def "User 조회 테스트"()

    {
        given:
        String accessToken = obtainAccessToken("jihoon","pass");

        // when + then
        expect:
        given(this.spec)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .filter(
                document("users",
                        requestHeaders(
                                headerWithName("Authorization").description("Basic auth credentials")
                        ),
                        responseFields(
                                fieldWithPath("[]").type(JsonFieldType.array).description("An array of subsystems"),
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("user id"),
                                fieldWithPath("[].username").type(JsonFieldType.STRING).description("user name"),
                                fieldWithPath("[].password").type(JsonFieldType.STRING).description("user password"),
                                fieldWithPath("[].role").type(JsonFieldType.STRING).description("user role")
                        )
                ))
                .header("Authorization", "Bearer "+accessToken)
                .when().port(this.port).get("/users/user")
                .then().assertThat().statusCode(200)


    }

    // todo. static 메소드로
    // 참고 : https://minwan1.github.io/2018/02/24/2018-03-11-Spring-OAuth%EA%B5%AC%ED%98%84/
    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "test");
        params.add("username", username);
        params.add("password", password);

        Response res = given(this.spec).accept(ContentType.JSON)
                .header("Content-Type", ContentType.URLENC)
                .header("Authorization", "Basic dGVzdDoxMjM0")
                .formParam("username", "jihoon")
                .formParam("password", "pass")
                .formParam("grant_type", "password")
                .when().port(this.port).post("/oauth/token")

        JacksonJsonParser jsonParser = new JacksonJsonParser()
        return jsonParser.parseMap(res.then().extract().response().asString()).get("access_token").toString();
    }
}