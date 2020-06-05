package render;

import java.util.ArrayDeque;

public class RenderPipeline {
  public class PipelineContext {
    //
  }

  public interface RenderStep {
    RenderStep doStep(PipelineContext ctx);
  }

  public static final RenderStep MODEL_TO_WORLD = (ctx) -> null; //
  public static final RenderStep WORLD_TO_VIEW = (ctx) -> null; //
  public static final RenderStep CULL = (ctx) -> null; // cull tris
  public static final RenderStep VIEW_TO_PROJECTION = (ctx) -> null; //
  public static final RenderStep RENDER_TO_SCREEN = (ctx) -> null; //


  private ArrayDeque<RenderStep> steps = new ArrayDeque<>();

  public RenderPipeline() {
    //
  }

  public RenderPipeline then(RenderStep step) {
    steps.add(step);

    return this;
  }

  public void render() {
    for (RenderStep step : steps) {
      step.doStep(new PipelineContext());
    }
  }
}
