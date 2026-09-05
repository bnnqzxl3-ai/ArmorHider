package ru.armorhider;

/**
 * Состояние мода. Броня и элитры скрываются только на твоём экране —
 * остальные игроки по-прежнему видят всё как обычно, и защита работает.
 */
public final class ArmorHider {

    private static boolean hidden = false;

    private ArmorHider() {
    }

    public static boolean isHidden() {
        return hidden;
    }

    public static boolean toggle() {
        hidden = !hidden;
        return hidden;
    }
}
