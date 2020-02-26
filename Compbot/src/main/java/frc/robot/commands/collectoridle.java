
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;

public class collectoridle extends CommandBase {
  private final shooter s_Shooter;
  /**
   * Creates a new collecteridle.
   */
  public collectoridle(shooter subsystem) {

    s_Shooter = subsystem;
    addRequirements(subsystem);

  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    s_Shooter.idle();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
