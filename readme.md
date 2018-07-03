# Use
For run JavaFX stage, you don't must create classes extend of Application.
You only run code:
```
IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml");
stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
stageFactory.setController(new ProgramControllerFX());
stageFactory.setTitle("MyApp");
FXStage stage = stageFactory.create();
stage.showAndWaitFX();
```