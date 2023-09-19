package io.github.moulberry.moulconfig.common;

public interface RenderContext {
    void pushMatrix();

    void popMatrix();

    void translate(float x, float y, float z);

    void scale(float x, float y, float z);

    void color(float r, float g, float b, float a);

    boolean isMouseButtonDown(int mouseButton);

    boolean isKeyboardKeyDown(int keyboardKey);

    default boolean isShiftDown() {
        return isKeyboardKeyDown(KeyboardConstants.KEY_LSHIFT) || isKeyboardKeyDown(KeyboardConstants.KEY_RSHIFT);
    }

    default boolean isCtrlDown() {
        return isKeyboardKeyDown(KeyboardConstants.KEY_LCONTROL) || isKeyboardKeyDown(KeyboardConstants.KEY_RCONTROL);
    }

    default void drawStringScaledMaxWidth(String text, IFontRenderer fontRenderer, int x, int y, boolean shadow, int width, int color) {
        pushMatrix();
        translate(x, y, 0);
        float scale = Math.min(1F, Math.max(0.1F, width / (float) fontRenderer.getStringWidth(text)));
        scale(scale, scale, 1F);
        fontRenderer.drawString(text, 0, 0, color, shadow);
        popMatrix();
    }

    void drawColoredRect(float left, float top, float right, float bottom, int color);

    void invertedRect(float left, float top, float right, float bottom);

    void drawTexturedRect(float x, float y, float width, float height);

    void renderDarkRect(int x, int y, int width, int height);

    void pushScissor(int left, int top, int right, int bottom);

    void popScissor();
}