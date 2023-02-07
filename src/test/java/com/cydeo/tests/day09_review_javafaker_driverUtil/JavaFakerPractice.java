package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){

        //Creat Java Faker object.
        Faker faker = new Faker();

        //Print out random first name using Faker object

        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //Print out a random last name using Faker object

        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //Print out full name using Faker object

        System.out.println("faker.name.fullName() = " + faker.name().fullName());

        //Print out City
        System.out.println("faker.address().city() = " + faker.address().city());

        //print out a zip code

        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());


        //numerfiy() method is used to generate digits with specific formatting
        System.out.println("phone number = " + faker.numerify("###-###-####"));


        System.out.println("faker.numerify(\"####-####-####-####\") = " + faker.numerify("####-####-####-####"));
        System.out.println("faker.numerify(\"999-###-###\") = " + faker.numerify("999-###-###"));


        //letterify() method is used to generate RANDOM letters with specific formatting
        System.out.println("faker.letterify(\"????-????-????\") = " + faker.letterify("????-????-????"));

        // bothify() method is used to generate both letters and digits randomly
        System.out.println("faker.bothify(\"#?-?#?#?#?#-?#?#?###-??\") = " + faker.bothify("#?-?#?#?#?#-?#?#?###-??"));

        //chuckNorris method is used to create chuckNorris fact
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.Muhtar().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));

    }
}
