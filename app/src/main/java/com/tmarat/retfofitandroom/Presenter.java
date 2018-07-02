package com.tmarat.retfofitandroom;

public class Presenter implements Contract.Presenter {
  private Contract.Model model;

  Presenter(Contract.View view) {
    this.model = new Model();
  }

  @Override public void getUserInput(String userInput) {

  }
}
