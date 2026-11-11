package com.themourad.essx;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class EssxScreen extends Screen {
    private String activeTab = "Home";

    public EssxScreen() {
        super(Component.literal("ESSX"));
    }

    @Override
    protected void init() {
        int left = Math.max(12, (this.width - 720) / 2);
        int top = Math.max(12, (this.height - 390) / 2);

        String[] tabs = {"Home", "Friends", "Messages", "Invites", "Gallery", "Wardrobe", "Settings"};
        int tabWidth = 96;
        for (int i = 0; i < tabs.length; i++) {
            final String tab = tabs[i];
            addRenderableWidget(Button.builder(Component.literal(tab), button -> activeTab = tab)
                .bounds(left + 14 + i * (tabWidth + 4), top + 52, tabWidth, 22)
                .build());
        }

        addRenderableWidget(Button.builder(Component.literal("Close"), button -> onClose())
            .bounds(left + 640, top + 350, 64, 22)
            .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        int panelWidth = Math.min(720, this.width - 24);
        int panelHeight = Math.min(390, this.height - 24);
        int left = (this.width - panelWidth) / 2;
        int top = (this.height - panelHeight) / 2;

        graphics.fill(0, 0, this.width, this.height, 0x99060A12);
        graphics.fill(left, top, left + panelWidth, top + panelHeight, 0xFF111827);
        graphics.fill(left, top, left + panelWidth, top + 38, 0xFF202C43);
        graphics.drawString(this.font, "ESSX", left + 16, top + 14, 0xFFFFFFFF);
        graphics.drawString(this.font, "Minecraft social client", left + 76, top + 14, 0xFFB9C7DD);

        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawString(this.font, activeTab, left + 18, top + 96, 0xFFFFFFFF);
        graphics.drawString(this.font, getTabDescription(), left + 18, top + 120, 0xFFB9C7DD);

        if (activeTab.equals("Home")) {
            graphics.drawString(this.font, "Welcome to ESSX.", left + 18, top + 160, 0xFFFFFFFF);
            graphics.drawString(this.font, "Your social space, screenshots and cosmetics — in one place.", left + 18, top + 180, 0xFFB9C7DD);
            graphics.drawString(this.font, "Right Shift opens this menu in-game.", left + 18, top + 220, 0xFF7DD3FC);
        } else if (activeTab.equals("Friends")) {
            graphics.drawString(this.font, "Your friends list will appear here when the ESSX service is connected.", left + 18, top + 160, 0xFFB9C7DD);
        } else if (activeTab.equals("Messages")) {
            graphics.drawString(this.font, "Private messages need the secure ESSX online service.", left + 18, top + 160, 0xFFB9C7DD);
        } else if (activeTab.equals("Invites")) {
            graphics.drawString(this.font, "Game and party invites will appear here.", left + 18, top + 160, 0xFFB9C7DD);
        } else if (activeTab.equals("Gallery")) {
            graphics.drawString(this.font, "Your shared screenshots gallery will appear here.", left + 18, top + 160, 0xFFB9C7DD);
        } else if (activeTab.equals("Wardrobe")) {
            graphics.drawString(this.font, "Cosmetics and skin customization will live here.", left + 18, top + 160, 0xFFB9C7DD);
        } else if (activeTab.equals("Settings")) {
            graphics.drawString(this.font, "ESSX settings will live here. No passwords or Microsoft tokens are collected.", left + 18, top + 160, 0xFFB9C7DD);
        }
    }

    private String getTabDescription() {
        return switch (activeTab) {
            case "Friends" -> "Friends and presence";
            case "Messages" -> "Direct messages";
            case "Invites" -> "Join your friends";
            case "Gallery" -> "Screenshots and sharing";
            case "Wardrobe" -> "Your look in Minecraft";
            case "Settings" -> "Customize your ESSX experience";
            default -> "Your Minecraft social hub";
        };
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
