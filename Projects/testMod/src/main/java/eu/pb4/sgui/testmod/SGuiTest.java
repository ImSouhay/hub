package eu.pb4.sgui.testmod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import eu.pb4.sgui.api.gui.*;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SGuiTest {

    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("SGUITest")
                .executes(SGuiTest::test6));
    }
    public static int test6(CommandContext<CommandSourceStack> objectCommandContext) {
        try {
            ServerPlayer player = objectCommandContext.getSource().getPlayer();
            SignGui gui = new SignGui(player) {
                private int tick = 0;

                {
                    this.setSignType(Blocks.ACACIA_WALL_SIGN);
                    this.setColor(DyeColor.WHITE);
                    this.setLine(1, Component.literal("^"));
                    this.setLine(2, Component.literal("Input your"));
                    this.setLine(3, Component.literal("value here"));
                    this.setAutoUpdate(false);
                }

                @Override
                public void onClose() {
                    this.player.sendSystemMessage(Component.literal("Input was: " + this.getLine(0).getString()), false);
                }

                @Override
                public void onTick() {

                }
            };
            gui.open();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
