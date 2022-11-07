package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Meteorito extends Actor {

    private static TextureRegion[] meteorito = new TextureRegion[6];
    private TextureRegion regionActual;
    private int numeroMeteorito;

    public Meteorito(float x, float y) {
        Texture completo = new Texture(Gdx.files.internal("spacetheme.png"));
        meteorito[0] = new TextureRegion(completo, 0, 300, 55, 63);
        meteorito[1] = new TextureRegion(completo, 100, 270, 20, 20);
        meteorito[2] = new TextureRegion(completo, 65, 250, 35, 55);
        meteorito[3] = new TextureRegion(completo, 65, 300, 25, 45);
        meteorito[4] = new TextureRegion(completo, 100, 270, 20, 20);
        meteorito[5] = new TextureRegion(completo, 90, 300, 25, 30);
        numeroMeteorito = MathUtils.random(0, 5);
        regionActual = meteorito[0];
    }

    public Meteorito() {
        this(400, 240);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(regionActual, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(),
                this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
    }

    @Override
    public void act(float delta) {
        this.moveBy(0, -250 * Gdx.graphics.getDeltaTime());
        this.rotateBy(180 * Gdx.graphics.getDeltaTime() / 2);
        if (getY() < 0 - getHeight()) {
            numeroMeteorito = MathUtils.random(0, 5);

            if (numeroMeteorito == 0) {
                regionActual = meteorito[0];
                generarMeteorito();
            }
            if (numeroMeteorito == 1) {
                regionActual = meteorito[1];
                generarMeteorito();
            }
            if (numeroMeteorito == 2) {
                regionActual = meteorito[2];
                generarMeteorito();
            }
            if (numeroMeteorito == 3) {
                regionActual = meteorito[3];
                generarMeteorito();
            }
            if (numeroMeteorito == 4) {
                regionActual = meteorito[4];
                generarMeteorito();
            }
            if (numeroMeteorito == 5) {
                regionActual = meteorito[5];
                generarMeteorito();
            }
        }
    }

    public void generarMeteorito() {
        setSize(regionActual.getRegionWidth(), regionActual.getRegionHeight());
        setPosition(MathUtils.random(0, 640 - regionActual.getRegionWidth()), 480);
    }
}
