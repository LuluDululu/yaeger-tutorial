module waterworld {
    requires hanyaeger;
    requires java.desktop;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
}
