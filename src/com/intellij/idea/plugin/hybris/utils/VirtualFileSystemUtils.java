package com.intellij.idea.plugin.hybris.utils;

import com.intellij.openapi.util.io.FileUtil;

/**
 * Created 1:51 AM 13 June 2015
 *
 * @author Alexander Bartash <AlexanderBartash@gmail.com>
 */
public final class VirtualFileSystemUtils {

    private VirtualFileSystemUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Should never be accessed.");
    }

    public static String normalize(String path) {
        path = FileUtil.toSystemIndependentName(path);
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        while (path.contains("/./")) {
            path = path.replace("/./", "/");
        }
        if (path.startsWith("./")) {
            path = path.substring(2);
        }
        if (path.endsWith("/.")) {
            path = path.substring(0, path.length() - 2);
        }

        while (true) {
            final int index = path.indexOf("/..");
            if (0 > index) {
                break;
            }
            final int slashIndex = path.substring(0, index).lastIndexOf("/");
            if (0 > slashIndex) {
                break;
            }
            path = path.substring(0, slashIndex) + path.substring(index + 3);
        }

        return path;
    }

    public static String getRelative(String baseRoot, String path) {
        baseRoot = normalize(baseRoot);
        path = normalize(path);

        final int prefix = findCommonPathPrefixLength(baseRoot, path);

        if (0 != prefix) {
            baseRoot = baseRoot.substring(prefix);
            path = path.substring(prefix);
            if (!baseRoot.isEmpty()) {
                return normalize(revertRelativePath(baseRoot.substring(1)) + path);
            } else if (!path.isEmpty()) {
                return path.substring(1);
            } else {
                return ".";
            }
        } else if (FileUtil.isAbsolute(path)) {
            return path;
        } else {
            return normalize(revertRelativePath(baseRoot) + "/" + path);
        }
    }

    public static int findCommonPathPrefixLength(final String path1, final String path2) {
        int end = -1;
        do {
            final int beg = end + 1;
            final int new_end = endOfToken(path1, beg);
            if (new_end != endOfToken(path2, beg) || !path1.substring(beg, new_end).equals(path2.substring(beg, new_end))) {
                break;
            }
            end = new_end;
        }
        while (end != path1.length());
        return 0 > end ? 0 : end;
    }

    private static int endOfToken(final String s, int index) {
        index = s.indexOf("/", index);
        return (-1 == index) ? s.length() : index;
    }

    private static String revertRelativePath(final String path) {
        if (path.equals(".")) {
            return path;
        } else {
            final StringBuilder sb = new StringBuilder();
            sb.append("..");
            int count = normalize(path).split("/").length;
            while (0 < --count) {
                sb.append("/..");
            }
            return sb.toString();
        }
    }
}