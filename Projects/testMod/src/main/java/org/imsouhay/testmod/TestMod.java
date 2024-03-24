package org.imsouhay.testmod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import eu.pb4.sgui.testmod.SGuiTest;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.MOD_ID)
public class TestMod {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "testmod";

    private static String command="";


    public TestMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("testCommand")
                .executes(context -> run(context, event.getDispatcher())));

        event.getDispatcher().register(Commands.literal("anotherTest")
                .executes(context -> ruun(context, event.getDispatcher())));

        event.getDispatcher().register(Commands.literal("setCommand")
                        .then(Commands.argument("string", StringArgumentType.string()))
                .executes(TestMod::setString));

        SGuiTest.register(event.getDispatcher());
    }

    public static int run(CommandContext<CommandSourceStack> context, CommandDispatcher dispatcher) {
        try {
            dispatcher.execute("gamemode creative ImSouhay",
                    context.getSource().getServer().createCommandSourceStack().withPermission(2));
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static int ruun(CommandContext<CommandSourceStack> context, CommandDispatcher dispatcher) {
        try {
            dispatcher.execute(command,
                    context.getSource().getServer().createCommandSourceStack().withPermission(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static int setString(CommandContext<CommandSourceStack> context) {
        command=context.getArgument("string", String.class);
        return 1;
    }
}
