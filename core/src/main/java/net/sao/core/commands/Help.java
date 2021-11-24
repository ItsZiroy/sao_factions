package net.sao.core.commands;

import net.sao.core.SaoCorePlugin;
import net.sao.core.command.abstraction.CommandArgument;
import net.sao.core.command.abstraction.CommandMetaData;
import net.sao.core.command.abstraction.SingleCommand;
import net.sao.core.command.permissions.CommandPermission;
import net.sao.core.sender.Sender;

import java.util.List;

public class Help extends SingleCommand {
    protected Help(String name, CommandMetaData meta, CommandPermission permission, CommandArgument[] args) {
        super(name, meta, permission, args);
    }

    @Override
    public void execute(SaoCorePlugin plugin, Sender sender, List<String> args) {

    }


}
