package eu.pb4.sgui.virtual;

import eu.pb4.sgui.api.gui.GuiInterface;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;

public interface VirtualScreenHandlerInterface {
    void addListener(ContainerListener listener);

    GuiInterface getGui();

    boolean canUse(Player player);

    void sendContentUpdates();

    ItemStack quickMove(Player player, int index);
}
