module edu.ufp.inf.aed2_lp2_2324_students {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires edu.princeton.cs.algs4;
    requires java.desktop;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;

    opens edu.ufp.inf.lp2.p06_gui_javafx.helloword to javafx.fxml;
    exports edu.ufp.inf.lp2.p06_gui_javafx.helloword;
    exports edu.ufp.inf.lp2.p06_gui_javafx.calc;
    exports edu.ufp.inf.lp2.p06_gui_javafx.login;
    exports edu.ufp.inf.lp2.p06_gui_javafx.Gui_BT;

}