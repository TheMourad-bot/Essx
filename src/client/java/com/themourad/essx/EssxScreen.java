package com.themourad.essx;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class EssxScreen extends Screen {
    private static final String[] TABS = {
        "Home", "Friends", "Messages", "Invites", "Gallery", "Wardrobe", "Settings"
    };

    private String activeTab = "Home";

    public EssxScreen() {
        super(Component.literal("ESSX"));
    }

    @Override
    protected void init() {
        int panelLeft = Math.max(12, (this.width - 760) / 2);
        int panelTop = Math.max(12, (this.height - 440) / 2);
        int sidebarX = panelLeft + 16;
        int sidebarY = panelTop + 76;

        for (int i = 0; i < TABS.length; i++) {
            String tab = TABS[i];
            int y = sidebarY + i * 34;
            this.addRenderableWidget(Button.builder(Component.literal(tab), button -> {
                activeTab = tab;
                rebuildWidgets();
            }).bounds(sidebarX, y, 148, 26).build());
        }

        this.addRenderableWidget(Button.builder(Component.literal("Close"), button -> onClose())
            .bounds(panelLeft + 674, panelTop + 400, 68, 24)
            .build());
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        int panelWidth = Math.min(760, this.width - 24);
        int panelHeight = Math.min(440, this.height - 24);
        int left = (this.width - panelWidth) / 2;
        int top = (this.height - panelHeight) / 2;
        int contentLeft = left + 190;

        graphics.fill(0, 0, this.width, this.height, 0x99050A12);
        graphics.fill(left, top, left + panelWidth, top + panelHeight, 0xFF101722);
        graphics.fill(left, top, left + panelWidth, top + 54, 0xFF182334);
        graphics.fill(left, top + 54, left + 176, top + panelHeight, 0xFF131D2B);
        graphics.fill(contentLeft, top + 76, left + panelWidth - 18, top + panelHeight - 52, 0xFF172231);

        graphics.text(this.font, "ESSX", left + 20, top + 18, 0xFFFFFFFF, true);
        graphics.text(this.font, "MINECRAFT SOCIAL", left + 82, top + 21, 0xFF8EA4C2, false);
        graphics.text(this.font, "YOUR SPACE. YOUR PEOPLE.", left + 20, top + 64, 0xFF6E87A8, false);

        graphics.text(this.font, activeTab, contentLeft + 20, top + 94, 0xFFFFFFFF, true);
        graphics.text(this.font, getSubtitle(), contentLeft + 20, top + 116, 0xFF9BAFC9, false);

        drawContent(graphics, contentLeft + 20, top + 158);

        graphics.text(this.font, "ESSX  •  EARLY ACCESS", left + 20, top + panelHeight - 26, 0xFF72849D, false);
    }

    private void drawContent(GuiGraphicsExtractor graphics, int x, int y) {
        switch (activeTab) {
            case "Home" -> {
                graphics.text(this.font, "Welcome to ESSX", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Your Minecraft social hub is ready to take shape.", x, y + 24, 0xFFB6C5D9, false);
                graphics.text(this.font, "Right Shift opens this menu in-game.", x, y + 58, 0xFF79C8FF, false);
                graphics.text(this.font, "Online services are not connected yet.", x, y + 92, 0xFFFFC979, false);
            }
            case "Friends" -> {
                graphics.text(this.font, "Friends list", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Your friends will appear here when an ESSX account service exists.", x, y + 28, 0xFFB6C5D9, false);
            }
            case "Messages" -> {
                graphics.text(this.font, "Private messages", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Messaging will be enabled after the secure service is built.", x, y + 28, 0xFFB6C5D9, false);
            }
            case "Invites" -> {
                graphics.text(this.font, "Party invites", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Join and invite friends here once online support is ready.", x, y + 28, 0xFFB6C5D9, false);
            }
            case "Gallery" -> {
                graphics.text(this.font, "Screenshot gallery", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Local screenshot browsing is planned for a later stage.", x, y + 28, 0xFFB6C5D9, false);
            }
            case "Wardrobe" -> {
                graphics.text(this.font, "Wardrobe", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "Cosmetic previews and equipped looks will live here.", x, y + 28, 0xFFB6C5D9, false);
            }
            case "Settings" -> {
                graphics.text(this.font, "Settings", x, y, 0xFFFFFFFF, true);
                graphics.text(this.font, "The menu opens with Right Shift.", x, y + 28, 0xFFB6C5D9, false);
                graphics.text(this.font, "No Microsoft passwords or account tokens are collected.", x, y + 54, 0xFF8FD6B0, false);
            }
            default -> graphics.text(this.font, "Coming soon.", x, y, 0xFFB6C5D9, false);
        }
    }

    private String getSubtitle() {
        return switch (activeTab) {
            case "Friends" -> "Find your people";
            case "Messages" -> "Keep the conversation going";
            case "Invites" -> "Play together";
            case "Gallery" -> "Your moments";
            case "Wardrobe" -> "Make it yours";
            case "Settings" -> "Tune your experience";
            default -> "Your Minecraft social hub";
        };
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
