package net.sao.core.command.abstraction;

import net.sao.core.SaoCorePlugin;
import net.sao.core.command.permissions.CommandPermission;
import net.sao.core.sender.Sender;

import java.util.List;

public abstract class Command {

    private final String name;
    private final CommandMetaData meta;
    private final CommandPermission permission;
    private final CommandArgument[] args;

    protected Command(String name, CommandMetaData meta, CommandPermission permission, CommandArgument[] args) {
        this.name = name;
        this.meta = meta;
        this.permission = permission;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public CommandPermission getPermission() {
        return permission;
    }

    public CommandArgument[] getArgs() {
        return args;
    }

    public String getUsage() {
        return this.meta.usage();
    }

    public String getLabel() {
        return this.meta.label();
    }

    public String getDescription() {
        return this.meta.description();
    }

    public abstract void execute(SaoCorePlugin plugin, Sender sender, List<String> args);
}
