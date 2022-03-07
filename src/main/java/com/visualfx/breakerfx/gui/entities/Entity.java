package com.visualfx.breakerfx.gui.entities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Entity {
    private Point2D position;
    private float rotation;
    private float scale = 1;
    private double width;
    private double height;

    Image entityImage;

    public Entity(Image entityImage) {
        this.entityImage = entityImage;
    }

    //TODO Maybe split position image and specially movement into subclasses or static classes.
    // Position

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position = new Point2D(x, y);
    }

    private void rotate(float rotation) {
        this.rotation += rotation;
    }

    private void move(Point2D vector) {
        this.position = this.position.add(vector);
    }

    public float getRotation() {
        return rotation;
    }

    public float getScale() {
        return scale;
    }

    public Point2D getCenter() {
        Point2D pos = getPosition();
        return new Point2D(pos.getX() + width / 2, pos.getY() + height / 2);
    }

    // Image

    public Image getEntityImage() {
        return entityImage;
    }

    public double getWidth() {
        return width * getScale();
    }

    public double getHeight() {
        return height * getScale();
    }

    // Movement

    private final float MAX_SPEED = 5f;
    private final float MAX_TORQUE = 5f;

    private Point2D currentThrustVector = new Point2D(0, 0);
    private float currentTorque = 0;

    public void update() {
        move(currentThrustVector);
        rotate(currentTorque);
    }

    public void addThrustForce(double scalar) {
        currentThrustVector = calculateThrust(scalar, Math.toRadians(-getRotation()));
        // Vectors magnitude can only be positive.
        if (currentThrustVector.magnitude() > MAX_SPEED) {
            currentThrustVector = currentThrustVector.normalize().multiply(MAX_SPEED);
        }
    }

    private Point2D calculateThrust(double scalar, double angle) {
        return new Point2D((float) (scalar * Math.sin(angle)), (float) (scalar * Math.cos(angle)));
    }

    public void addTorque(float torque) {
        float newTorque = currentTorque + torque;
        if (torque > 0 ) {
            currentTorque = Math.min(newTorque, MAX_TORQUE);
        } else {
            currentTorque = Math.max(newTorque, -MAX_TORQUE);
        }
    }

    // Has the possibility to add drag.
}