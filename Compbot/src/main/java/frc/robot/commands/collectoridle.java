
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector;

public class collectoridle extends CommandBase {
  private final collector s_Collector;
  /**
   * Creates a new collecteridle.
   */
  public collectoridle(collector subsystem) {

    s_Collector = subsystem;
    addRequirements(subsystem);

  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    s_Collector.idle();
    s_Collector.armpos();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
