package net.sao.core.command.abstraction;

public record CommandArgument(String name, boolean required, String description) {
}
