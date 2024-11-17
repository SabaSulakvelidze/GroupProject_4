package com.example.GroupProject_4.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        Contact myContacts = new Contact()
                .name("Saba Sulakvelidze")
                .email("sabasulakvelidze@mail.com")
                .url("https://youtu.be/dQw4w9WgXcQ?si=1m2bK3kGORsgOV_r");

        Info myInfo = new Info()
                .title("SkillWill Project #4&5")
                .description("this is Project #4 and #5")
                .version("0.6")
                .contact(myContacts);

        ExternalDocumentation additionalDocumentation = new ExternalDocumentation()
                .description("Additional Documentation")
                .url("https://yourdocumentation.com");

        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Server");

        return new OpenAPI().info(myInfo)
                .externalDocs(additionalDocumentation)
                .addServersItem(localServer);
    }
}
