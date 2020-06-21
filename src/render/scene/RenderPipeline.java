package render.scene;

import java.util.ArrayDeque;

public class RenderPipeline {
  public static final RenderStep MODEL_TO_WORLD = (ctx) -> null; //
  public static final RenderStep WORLD_TO_VIEW = (ctx) -> null; //
  public static final RenderStep CULL = (ctx) -> null; // cull tris
  public static final RenderStep VIEW_TO_PROJECTION = (ctx) -> null; //
  public static final RenderStep RENDER_TO_SCREEN = (ctx) -> null; //

  public class PipelineContext {
    //
  }

  @FunctionalInterface
  public interface RenderStep {
    RenderStep doStep(PipelineContext ctx);
  }

  private final ArrayDeque<RenderStep> steps = new ArrayDeque<>();

  public RenderPipeline() {
    //
  }

  public RenderPipeline then(RenderStep step) {
    steps.add(step);

    return this;
  }

  public void lastly(RenderStep step) {
    steps.add(step);
  }

  public void render() {
    PipelineContext ctx = new PipelineContext();

    for (RenderStep step : steps) {
      step.doStep(ctx);
      // verifyContext(ctx);
    }

    // lastly (cleanup, blit to texture, etc.)
  }
}
