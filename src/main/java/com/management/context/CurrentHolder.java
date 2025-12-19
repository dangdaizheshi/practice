package com.management.context;

public class CurrentHolder {
    private static final ThreadLocal<Integer> currentHolder = new ThreadLocal<>();
    public static void setCurrent(Integer current) {
        currentHolder.set(current);
    }
    public static Integer getCurrent() {
        return currentHolder.get();
    }
    public static void clear() {
        currentHolder.remove();
    }
}
