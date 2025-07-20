package com.malloc.taskmanager.application.port.in.command;

public class CreateTaskCommand {

  private final String title;
  private final String description;

  public CreateTaskCommand(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String title() {
    return title;
  }

  public String description() {
    return description;
  }
}
