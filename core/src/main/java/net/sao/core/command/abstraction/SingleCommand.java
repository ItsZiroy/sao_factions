package net.sao.core.command.abstraction;

import net.sao.core.command.permissions.CommandPermission;

public abstract class SingleCommand extends Command {

    protected SingleCommand(String name, CommandMetaData meta, CommandPermission permission, CommandArgument[] args) {
        super(name, meta, permission, args);
    }
}
