package com.visualfx.breakerfx.systems;

import com.visualfx.breakerfx.gui.entities.Entity;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    private final Canvas canvas;
    private final GraphicsContext gc;

    private Image background;

    List<Entity> entities = new ArrayList<>();

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }

    public void render() {
        gc.save();

        if (background != null) {
            gc.drawImage(background, 0, 0);
        }

        for (Entity entity : entities) {
            transformGC(entity);

            Point2D pos = entity.getPosition();
            gc.drawImage(
                    entity.getEntityImage(),
                    pos.getX(),
                    pos.getY(),
                    entity.getWidth(),
                    entity.getHeight()
            );
        }

        gc.restore();
    }

    private void transformGC(Entity entity) {
        Point2D center = entity.getCenter();
        Rotate r = new Rotate(entity.getRotation(), center.getX(), center.getY());
        gc.transform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public void prepare() {
        gc.setFill(new Color(0.68, 0.68, 0.68, 1));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void clearEntities() {
        entities.clear();
    }
}