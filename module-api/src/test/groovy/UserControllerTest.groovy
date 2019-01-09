import com.dz.ApiApplication
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.Rule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.payload.JsonFieldType
import spock.lang.Specification

import static io.restassured.RestAssured.given
import static org.hamcrest.CoreMatchers.is
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
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

    void setup() {
        this.spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(this.restDocumentation))
                .build()
    }

    def "User 조회 테스트"()

    {
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
            .header("Authorization", "Bearer 710a0318-3b86-46fe-a076-f264baa81523")
            .when().port(this.port).get("/users/user")
            .then().assertThat().statusCode(is(200))

    }

}