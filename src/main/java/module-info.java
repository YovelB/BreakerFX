module com.visualfx.breakerfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    requires org.apache.logging.log4j;

    opens com.visualfx.breakerfx to javafx.fxml;
    opens com.visualfx.breakerfx.gui.controllers to javafx.fxml;
    exports com.visualfx.breakerfx;
}