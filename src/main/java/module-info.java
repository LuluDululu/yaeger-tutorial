module waterworld {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.entities.map;
}
