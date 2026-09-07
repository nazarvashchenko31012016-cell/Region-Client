package com.regionclient.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import com.regionclient.RegionClientModClient;
import com.regionclient.module.Module;

import java.util.ArrayList;
import java.util.List;

public class HUDEditor extends Screen {
    private static final int DARK_BG = 0xFF1A1A1A;
    private static final int ACCENT_COLOR = 0xFF7B2CBF;
    private static final int GRID_SIZE = 10;

    private Module selectedModule = null;
    private final List<HUDElement> hudElements = new ArrayList<>();
    private boolean showGrid = true;
    private boolean showPreview = true;

    public HUDEditor() {
        super(Text.literal("Region Client - HUD Editor"));
        loadHUDElements();
    }

    private void loadHUDElements() {
        for (Module module : RegionClientModClient.MODULE_MANAGER.getModules()) {
            if (module.getCategory().equalsIgnoreCase("HUD")) {
                hudElements.add(new HUDElement(module));
            }
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        fill(matrices, 0, 0, this.width, this.height, DARK_BG);

        // Draw grid
        if (showGrid) {
            drawGrid(matrices);
        }

        // Draw HUD elements
        for (HUDElement element : hudElements) {
            element.render(matrices, mouseX, mouseY);
        }

        // Draw UI panel
        drawControlPanel(matrices, mouseX, mouseY);
    }

    private void drawGrid(MatrixStack matrices) {
        for (int x = 0; x < this.width; x += GRID_SIZE) {
            fill(matrices, x, 0, x + 1, this.height, 0x44FFFFFF);
        }
        for (int y = 0; y < this.height; y += GRID_SIZE) {
            fill(matrices, 0, y, this.width, y + 1, 0x44FFFFFF);
        }
    }

    private void drawControlPanel(MatrixStack matrices, int mouseX, int mouseY) {
        int panelX = this.width - 200;
        int panelY = 10;
        int panelWidth = 190;
        int panelHeight = 300;

        fill(matrices, panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF2A2A2A);

        // Panel title
        drawCenteredText(matrices, this.textRenderer, "Editor Controls", panelX + panelWidth / 2, panelY + 5, ACCENT_COLOR);

        // Grid toggle button
        drawButton(matrices, panelX + 10, panelY + 25, panelWidth - 20, 20, "Grid: " + (showGrid ? "ON" : "OFF"), mouseX, mouseY);

        // Preview toggle button
        drawButton(matrices, panelX + 10, panelY + 50, panelWidth - 20, 20, "Preview: " + (showPreview ? "ON" : "OFF"), mouseX, mouseY);

        // Reset button
        drawButton(matrices, panelX + 10, panelY + 75, panelWidth - 20, 20, "Reset Layout", mouseX, mouseY);

        // Save button
        drawButton(matrices, panelX + 10, panelY + 100, panelWidth - 20, 20, "Save Layout", mouseX, mouseY);

        // Load button
        drawButton(matrices, panelX + 10, panelY + 125, panelWidth - 20, 20, "Load Layout", mouseX, mouseY);
    }

    private void drawButton(MatrixStack matrices, int x, int y, int width, int height, String text, int mouseX, int mouseY) {
        boolean hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        int bgColor = hovered ? 0xFF7B2CBF : 0xFF3A3A3A;
        fill(matrices, x, y, x + width, y + height, bgColor);
        drawCenteredText(matrices, this.textRenderer, text, x + width / 2, y + 5, 0xFFFFFF);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Handle element dragging
        for (HUDElement element : hudElements) {
            if (element.isHovered((int) mouseX, (int) mouseY)) {
                selectedModule = element.module;
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (selectedModule != null) {
            // Update position
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC key
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        this.client.setScreen(null);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    private static class HUDElement {
        private final Module module;
        private int x;
        private int y;

        public HUDElement(Module module) {
            this.module = module;
            this.x = 50;
            this.y = 50;
        }

        public void render(MatrixStack matrices, int mouseX, int mouseY) {
            boolean hovered = isHovered(mouseX, mouseY);
            int bgColor = hovered ? 0xFF7B2CBF : 0xFF3A3A3A;
            fill(matrices, x, y, x + 100, y + 30, bgColor);
            drawCenteredText(matrices, null, module.getName(), x + 50, y + 10, 0xFFFFFF);
        }

        public boolean isHovered(int mouseX, int mouseY) {
            return mouseX >= x && mouseX <= x + 100 && mouseY >= y && mouseY <= y + 30;
        }
    }
}
