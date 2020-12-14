package model;

import java.util.ArrayList;

public interface ProjectManagementModel
{
  public ArrayList<Project> getAllProjects();
  public ArrayList<Project> getProjectsByStatus(String status);
  public ArrayList<Project> getProjectsBeforeDeadline(MyDate deadline);
  public Project getProjectById(String Id);
  public ArrayList<Requirement> getAllRequirements();
  public ArrayList<Requirement> getAllRequirementsByPriority(String priorityGroup);
  public ArrayList<Requirement> getRequirementsLinkedTo(Project project);
  public ArrayList<Requirement> getRequirementsLinkedTo(Task task);
  public ArrayList<Requirement> getRequirementsLinkedTo(Member member);
  public ArrayList<Requirement> getRequirementsByStatus(String status);
  public ArrayList<Requirement> getRequirementsBeforeDeadline(MyDate deadline);
  public Requirement getRequirementById(String Id);
  public ArrayList<Task> getAllTasks();
  public ArrayList<Task> getTasksLinkedTo(Project project);
  public ArrayList<Task> getTasksLinkedTo(Requirement requirement);
  public ArrayList<Task> getTasksLinkedTo(Member member);
  public ArrayList<Task> getTasksByStatus(String status);
  public ArrayList<Task> getTasksBeforeDeadline(MyDate deadline);
  public Task getTaskById(String Id);
  public ArrayList<Member> getAllMembers();
  public ArrayList<Member> getMembersLinkedTo(Project project);
  public ArrayList<Member> getMembersLinkedTo(Requirement requirement);
  public ArrayList<Member> getMembersLinkedTo(Task task);
  public Member getMemberByFullName(String firstName, String lastName);
  public Member getMemberByEmail(String email);

  public void createProject(String title, String description, float estimatedWorkHours, int day, int month, int year);
  public void createProject(String title, float estimatedWorkHours, int day, int month, int year);




}
