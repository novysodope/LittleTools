package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APKTools {
    public static void fingerprint(){
        System.out.println("\n" +
                "   _____                      _ _                         _____                    __                      _____  _____  \n" +
                "  / ____|                    | (_)                       / ____|                  / _|               /\\   |  __ \\|  __ \\ \n" +
                " | |     ___  _ __ ___  _ __ | |_  __ _ _ __   ___ ___  | (___   ___ __ _ _ __   | |_ ___  _ __     /  \\  | |__) | |__) |\n" +
                " | |    / _ \\| '_ ` _ \\| '_ \\| | |/ _` | '_ \\ / __/ _ \\  \\___ \\ / __/ _` | '_ \\  |  _/ _ \\| '__|   / /\\ \\ |  ___/|  ___/ \n" +
                " | |___| (_) | | | | | | |_) | | | (_| | | | | (_|  __/  ____) | (_| (_| | | | | | || (_) | |     / ____ \\| |    | |     \n" +
                "  \\_____\\___/|_| |_| |_| .__/|_|_|\\__,_|_| |_|\\___\\___| |_____/ \\___\\__,_|_| |_| |_| \\___/|_|    /_/    \\_\\_|    |_|     \n" +
                "                       | |                                                                                               \n" +
                "                       |_|                                                                                               \n" +
                "This version(0.1) is only used to extract all permission attributes of APK. Author: novy, Github: https://github.com/novysodope/LittleTools\n\n");
    }

    public static void main(String[] args) {
        fingerprint();
        if (args.length < 0 || args.length == 0) {
            System.out.println("Please Enter \"-h\" See Help");
            System.exit(0);
        }
        String apkPath = args[0];
        if (apkPath.equals("-h")) {
            System.out.println("java -jar ScanPermis.jar example.apk  --Single");
            System.out.println("java -jar ScanPermis.jar -f /folder_example/  --Batch\n");
            System.exit(0);
        }

        if (apkPath.equals("-f")) {
            String batch = args[1];
            File file = new File(batch);
            if (file.isFile()){
                System.out.println("You entered is not a folder");
                System.exit(0);
            }
            analyzeApkFolder(batch);
            System.exit(0);
        }
        
        File file = new File(apkPath);
        if (file.isFile()) {
            System.out.println("File from extraction " + apkPath);
            String fileName = extractFileName(apkPath);
            System.out.println("Folder: " + fileName);
            List<String> permissions = scanApkPermissions(apkPath, fileName);
            System.out.println(formatTable(permissions));
        }
        System.out.println("Please check your input!");
    }

    // apktool会根据文件名创建文件夹，这里提取文件名方便给scanApkPermissions方法用
    public static String extractFileName(String filePath) {
        File file = new File(filePath);
        String fileNameWithExtension = file.getName();
        int lastDotIndex = fileNameWithExtension.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return fileNameWithExtension.substring(0, lastDotIndex);
        } else {
            return fileNameWithExtension;
        }
    }

    public static List<String> scanApkPermissions(String apkPath, String fileName) {
        List<String> permissions = new ArrayList<>();

        try {
            Process process = Runtime.getRuntime().exec("java -jar apktool.jar d " + apkPath);
            process.waitFor();
            File manifestFile = new File(fileName + "/AndroidManifest.xml");
            BufferedReader br = new BufferedReader(new FileReader(manifestFile));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("uses-permission")) {
                    String permission = line.split("android:name=\"")[1].split("\"")[0];
                    permissions.add(permission);
                }
            }

            br.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return permissions;
    }

    // 批量扫描
    public static void analyzeApkFolder(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.isDirectory()) {
            System.out.println("Provided path is not a folder.");
            return;
        }

        File[] apkFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".apk"));

        if (apkFiles == null || apkFiles.length == 0) {
            System.out.println("No APK files found in the specified folder.");
            return;
        }

        for (File apkFile : apkFiles) {
            String apkPath = apkFile.getAbsolutePath();
            String fileName = extractFileName(apkPath);
            System.out.println("Analyzing APK: " + apkFile);
            System.out.println("Folder: " + fileName);
            List<String> permissions = scanApkPermissions(apkPath, fileName);

            System.out.println(formatTable(permissions));
        }
    }

    // 格式化表格
    public static String formatTable(List<String> permissions) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("| %-40s |%n", "Permissions List"));
        table.append("|------------------------------------------|\n");
        for (String permission : permissions) {
            table.append(String.format("| %-40s |%n", permission));
        }
        table.append("|------------------------------------------|\n");
        return table.toString();
    }
}
