package com.example.hafalapps.models;

public class ModelAlkautsar {
    private String surahName, surahUrl;

    public ModelAlkautsar() {
    }

    public ModelAlkautsar(String surahName, String surahUrl) {
        this.surahName = surahName;
        this.surahUrl = surahUrl;
    }

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public String getSurahUrl() {
        return surahUrl;
    }

    public void setSurahUrl(String surahUrl) {
        this.surahUrl = surahUrl;
    }
}
