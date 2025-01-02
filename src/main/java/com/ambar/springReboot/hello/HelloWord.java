package com.ambar.springReboot.hello;

public class HelloWord {

    private String greeting;

    public HelloWord(String s) {
        this.greeting = s;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
