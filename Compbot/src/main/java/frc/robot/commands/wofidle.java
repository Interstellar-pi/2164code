






package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.wofarm;

public class wofidle extends CommandBase {
  private final wofarm s_WOFArm;

  public wofidle(wofarm subsystem) {
    s_WOFArm = subsystem;
    addRequirements(subsystem);
  }

  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    s_WOFArm.stop();
  }

  
  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
