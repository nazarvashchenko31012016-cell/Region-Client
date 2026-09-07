package com.regionclient.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import com.regionclient.RegionClientModClient;
import com.regionclient.module.Module;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends Screen {
    private static final int DARK_BG = 0xFF1A1A1A;
    private static final int ACCENT_COLOR = 0xFF7B2CBF;
    private static final int PANEL_BG = 0xFF2A2A2A;
    private static final int HOVER_COLOR = 0xFF3A3A3A;

    private final List<CategoryPanel> categories = new ArrayList<>();
    private double scrollOffset = 0;
    private int selectedCategory = 0;

    public ClickGUI() {
        super(Text.literal("Region Client - ClickGUI"));
        initializeCategories();
    }

    private void initializeCategories() {
        String[] categoryNames = {"Combat", "Movement", "Render", "Player", "World", "Visuals", "Utility", "Misc"};
        int posX = 10;
        
        for (String category : categoryNames) {
            List<Module> modulesInCategory = new ArrayList<>();
            for (Module module : RegionClientModClient.MODULE_MANAGER.getModules()) {
                if (module.getCategory().equalsIgnoreCase(category)) {
                    modulesInCategory.add(module);
                }
            }
            categories.add(new CategoryPanel(category, posX, 30, modulesInCategory));
            posX += 120;
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        fill(matrices, 0, 0, this.width, this.height, DARK_BG);

        // Draw header
        drawCenteredText(matrices, this.textRenderer, "Region Client - ClickGUI", this.width / 2, 10, ACCENT_COLOR);

        // Draw categories
        for (int i = 0; i < categories.size(); i++) {
            CategoryPanel category = categories.get(i);
            category.render(matrices, mouseX, mouseY, delta, i == selectedCategory);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        scrollOffset += verticalAmount * 10;
        return true;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).isHovered((int) mouseX, (int) mouseY)) {
                selectedCategory = i;
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
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

    private static class CategoryPanel {
        private final String name;
        private final int x;
        private final int y;
        private final List<Module> modules;
        private boolean expanded = false;
        private static final int WIDTH = 110;
        private static final int HEIGHT = 20;

        public CategoryPanel(String name, int x, int y, List<Module> modules) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.modules = modules;
        }

        public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, boolean selected) {
            int bgColor = isHovered(mouseX, mouseY) ? HOVER_COLOR : (selected ? ACCENT_COLOR : PANEL_BG);
            fill(matrices, x, y, x + WIDTH, y + HEIGHT, bgColor);
            drawCenteredText(matrices, null, name, x + WIDTH / 2, y + 5, 0xFFFFFF);

            if (expanded) {
                int moduleY = y + HEIGHT + 5;
                for (Module module : modules) {
                    int moduleBg = 0xFF252525;
                    fill(matrices, x, moduleY, x + WIDTH, moduleY + HEIGHT, moduleBg);
                    drawCenteredText(matrices, null, module.getName(), x + WIDTH / 2, moduleY + 5, module.isEnabled() ? 0x00FF00 : 0xFFFFFF);
                    moduleY += HEIGHT + 2;
                }
            }
        }

        public boolean isHovered(int mouseX, int mouseY) {
            return mouseX >= x && mouseX <= x + WIDTH && mouseY >= y && mouseY <= y + HEIGHT;
        }
    }

    private static void drawCenteredText(MatrixStack matrices, Object renderer, String text, int x, int y, int color) {
        // Placeholder for text rendering
    }
}
