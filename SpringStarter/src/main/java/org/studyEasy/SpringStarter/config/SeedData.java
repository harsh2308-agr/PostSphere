package org.studyEasy.SpringStarter.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyEasy.SpringStarter.Models.Account;
import org.studyEasy.SpringStarter.Models.Authority;
import org.studyEasy.SpringStarter.Models.Post;
import org.studyEasy.SpringStarter.services.AccountService;
import org.studyEasy.SpringStarter.services.AuthorityService;
import org.studyEasy.SpringStarter.services.PostService;
import org.studyEasy.SpringStarter.util.constant.Privillages;
import org.studyEasy.SpringStarter.util.constant.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privillages auth : Privillages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("harshagrawal23601@gmail.com");
        account01.setPassword("password");
        account01.setFirstname("user01");
        account01.setLastname("lastname");
        account01.setAge(25);
        account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account01.setGender("Male");

        account02.setEmail("account02@studyEasy.org");
        account02.setPassword("password");
        account02.setFirstname("user02");
        account02.setLastname("lastname");
        account02.setRole(Roles.ADMIN.getRole());
        account02.setAge(25);
        account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account02.setGender("Female");

        account03.setEmail("account03@studyEasy.org");
        account03.setPassword("password");
        account03.setFirstname("user02");
        account03.setLastname("lastname");
        account03.setRole(Roles.EDITOR.getRole());
        account03.setAge(55);
        account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
        account03.setGender("Male");

        account04.setEmail("account04@studyEasy.org");
        account04.setPassword("password");
        account04.setFirstname("user02");
        account04.setLastname("lastname");
        account04.setRole(Roles.EDITOR.getRole());
        account04.setAge(40);
        account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
        account04.setGender("Female");

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.ACCESS_ANY_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.findAll();

        if (posts.size() == 0) {
            Post post01 = new Post();
            post01.setTitle("Spring Boot");
            post01.setBody(
                    """
                            Spring Boot is an open-source Java framework used for programming standalone, production-grade Spring-based applications with a
                            bundle of libraries that make project startup and management easier.[3] Spring Boot is a convention-over-configuration extension for the Spring Java platform intended to help minimize configuration concerns while creating Spring-based applications.[4][5] The application can still be adjusted for specific needs, but the initial Spring Boot project provides a preconfigured "opinionated view" of the best configuration to use with the Spring platform and selected third-party libraries.[6][7]
                            Spring Boot can be used to build microservices, web applications, and console applications.[3][8]
                            """);
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Angular");
            post02.setBody(
                    """
                                                Angular (also referred to as Angular 2+)[4] is a TypeScript-based free and open-source single-page web application framework. It is developed by Google and by a community of individuals and corporations. Angular is a complete rewrite from the same team that built AngularJS. The Angular ecosystem consists of a diverse group of over 1.7 million developers, library authors, and content creators.[5] According to the Stack Overflow Developer Survey, Angular is one of the most commonly used web frameworks.[6]

                            Differences between Angular and AngularJS

                            Architecture of an Angular application, services, and dependency injection
                            Google designed Angular as a ground-up rewrite of AngularJS. Unlike AngularJS, Angular does not have a concept of "scope" or controllers; instead, it uses a hierarchy of components as its primary architectural characteristic.[7] Angular has a different expression syntax, focusing on "[ ]" for property binding, and "( )" for event binding.[8] Angular recommends the use of Microsoft's TypeScript language, which introduces features such as static typing, generics, and type annotations.

                            Features
                            Component-based architecture
                            Angular uses a component-based architecture, which allows developers to build encapsulated, reusable user interface elements. Each component encapsulates its own HTML, CSS, and TypeScript, making it easier to manage and test individual pieces of an application.[9]

                            Data binding
                            Angular supports two-way data binding which synchronizes data between the model and the view. This ensures that any changes in the view are automatically reflected in the model and vice versa.[10]

                            Dependency injection
                            Angular has a built-in dependency injection system that makes it easier to manage and inject dependencies into components and services. This promotes modularity and easier testing.[11]

                            Directives
                                                """);
            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("GEN AI");
            post03.setBody(
                    """
                                                     Generative artificial intelligence (Generative AI, or GenAI[1]) is a subfield of artificial intelligence that uses generative models to produce text, images, videos, audio, software code or other forms of data.[2][3] These models learn the underlying patterns and structures of their training data and use them to produce new data[4][5] based on the input, which often comes in the form of natural language prompts.[6][7]

                            Generative AI tools have become more common since the AI boom in the 2020s. This boom was made possible by improvements in transformer-based deep neural networks, particularly large language models (LLMs). Major tools include chatbots such as ChatGPT, Copilot, Gemini, Claude, Grok, and DeepSeek; text-to-image models such as Stable Diffusion, Midjourney, and DALL-E; and text-to-video models such as Veo and Sora.[8][9][10] Technology companies developing generative AI include OpenAI, xAI, Anthropic, Meta AI, Microsoft, Google, Mistral AI, DeepSeek, Baidu[11] and Yandex.[12]

                            Generative AI is used across many industries, including software development,[13] healthcare,[14] finance,[15] entertainment,[16] customer service,[17] sales and marketing,[18] art, writing,[19] fashion,[20] and product design.[21]
                                                        """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Cloud Computing");
            post04.setBody(
                    """
                                                       "Cloud Computing" redirects here; not to be confused with Cloud Computing (horse).

                            Cloud computing metaphor: the group of networked elements providing services does not need to be addressed or managed individually by users; instead, the entire provider-managed suite of hardware and software can be thought of as an amorphous cloud.
                            Cloud computing is defined by the ISO as "a paradigm for enabling network access to a scalable and elastic pool of shareable physical or virtual resources with self-service provisioning and administration on demand".[1] It is commonly referred to as "the cloud".[2]

                            Characteristics
                            In 2011, the National Institute of Standards and Technology (NIST) identified five "essential characteristics" for cloud systems.[3] Below are the exact definitions according to NIST:[3]

                            On-demand self-service: "A consumer can unilaterally provision computing capabilities, such as server time and network storage, as needed automatically without requiring human interaction with each service provider."
                            Broad network access: "Capabilities are available over the network and accessed through standard mechanisms that promote use by heterogeneous thin or thick client platforms (e.g., mobile phones, tablets, laptops, and workstations)."
                            Resource pooling: " The provider's computing resources are pooled to serve multiple consumers using a multi-tenant model, with different physical and virtual resources dynamically assigned and reassigned according to consumer demand."
                                                        """);
            post04.setAccount(account01);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("Microservices");
            post05.setBody(
                    """
                            In software engineering, a microservice architecture is an architectural pattern that organizes an application into a collection of loosely coupled, fine-grained services that communicate through lightweight protocols. This pattern is characterized by the ability to develop and deploy services independently, improving modularity, scalability, and adaptability. However, it introduces additional complexity, particularly in managing distributed systems and inter-service communication, making the initial implementation more challenging compared to a monolithic architecture.[1]

                                                        Definition
                                                        There is no single, universally agreed-upon definition of microservices. However, they are generally characterized by a focus on modularity, with each service designed around a specific business capability. These services are loosely coupled, independently deployable, and often developed and scaled separately, enabling greater flexibility and agility in managing complex systems. Microservices architecture is closely associated with principles such as domain-driven design, decentralization of data and governance, and the flexibility to use different technologies for individual services to best meet their requirements.
                                                                                    """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("React");
            post06.setBody(
                    """
                                               React (also known as React.js or ReactJS) is a free and open-source front-end JavaScript library[5][6] that aims to make building user interfaces based on components more "seamless".[5] It is maintained by Meta (formerly Facebook) and a community of individual developers and companies.[7][8][9] According to the Stack Overflow Developer Survey, React is one of the most commonly used web technologies.[10]

                            React can be used to develop single-page, mobile, or server-rendered applications with frameworks like Next.js and React Router. Because React is only concerned with the user interface and rendering components to the DOM, React applications often rely on libraries for routing and other client-side functionality.[11][12] A key advantage of React is that it only re-renders those parts of the page that have changed, avoiding unnecessary re-rendering of unchanged DOM elements. React is used by an estimated 6% of all websites.[13]

                            Notable features
                            Declarative
                            React adheres to the declarative programming paradigm.[14][15]: 76  Developers design views for each state of an application, and React updates and renders components when data changes. This is in contrast with imperative programming.[16]

                            Components
                            React code is made of entities called components.[15]: 10–12  These components are modular and can be reused.[15]: 70  React applications typically consist of many layers of components. The components are rendered to a root element in the DOM using the React DOM library. When rendering a component, values are passed between components through props (short for "properties"). Values internal to a component are called its state.[17]

                            The two primary ways of declaring components in React are through function components and class components.[15]: 118 [18]: 10  Since React v16.8, using function components is the recommended way.
                                                """);
            
            post06.setAccount(account02);
            postService.save(post06);
        }

    }

}
