package com.mycompany.app;

public class App {
  public static void main(String [] args) {
    System.out.println("Hello world");

    FooBar fooBar = new FooBar("much fun");

    System.out.println("length bar: " + fooBar.getBar().length());
  }
}

class FooBar {
  private String value;

  public FooBar(String value) {
    this.value = value;
  }

  public String getBar() {
    return this.value;
  }
}

