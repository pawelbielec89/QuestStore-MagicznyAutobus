package com.codecool.queststore.view;

import com.codecool.queststore.model.Title;
import com.codecool.queststore.model.classes.CodecoolClass;
import com.codecool.queststore.model.shop.artifact.Artifact;
import com.codecool.queststore.model.shop.quest.Quest;
import com.codecool.queststore.model.shop.quest.QuestTemplate;
import com.codecool.queststore.model.user.User;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.util.List;

public class TemplateRender implements RenderInteface {

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes);

        return template.render(model);
    }

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes, CodecoolClass targetClass) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes, targetClass);

        return template.render(model);
    }

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes, String message) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes, message);

        return template.render(model);
    }

    @Override
    public String RenderClassPage(User currentUser, List<CodecoolClass> classes, List<User> users, int classID) {
        TemplateModelInterface tmi = new TemplateModelHandler();
        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/class.html");

        // create a model that will be passed to a template
        JtwigModel model = tmi.getClassModel(currentUser, classes, users, classID);

        return template.render(model);
    }

    @Override
    public String RenderProfilePage(User currentUser, User profile, List<CodecoolClass> classes) {
        /* Mentor profile model:
         *  currentUser - active user
         *  profile - user with data we want to show
         *  classes - list of Codecool Classes assigned to user
         */

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/profile.html");
        TemplateModelInterface tmi = new TemplateModelHandler();

        //render from args
        return template.render(tmi.getProfileMentorModel(currentUser, profile, classes));
    }

    @Override
    public String RenderProfilePage(User currentUser, User profile, CodecoolClass ccClass, List<Artifact> items) {
        /* Student profile model:
         *  currentUser - active user
         *  profile - user with data we want to show
         *  ccClass - CodecoolClass of user
         *  items - list of user's Artifacts
         */

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/profile.html");
        TemplateModelInterface tmi = new TemplateModelHandler();

        // render from args
        return template.render(tmi.getProfileStudentModel(currentUser, profile, ccClass, items));
    }

    @Override
    public String RenderProfilePage(User currentUser, List<Title> titles) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/profile.html");
        TemplateModelInterface tmi = new TemplateModelHandler();

        return template.render(tmi.getProfileAdminModel(currentUser, titles));
    }

    public String RenderMentorListPage(User currentUser, List<User> users, boolean isCreated) {
        /* User list model:
         *  currentUser - active user
         *  items - list of user's
         */
        TemplateModelInterface tmi = new TemplateModelHandler();

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/mentorList.html");

        return template.render(tmi.getMentorsListModel(currentUser, users, isCreated));
    }

    public String RenderStudentListPage(User currentUser, List<User> users, boolean isCreated, List<CodecoolClass> classes) {
        /* User list model:
         *  currentUser - active user
         *  items - list of user's
         */
        TemplateModelInterface tmi = new TemplateModelHandler();

        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/studentList.html");

        return template.render(tmi.getStudentsListModel(currentUser, users, isCreated, classes));
    }

    @Override
    public String RenderShopPage(User currentUser, List<Artifact> artifacts) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/shop.html");

        return template.render(tmi.getArtifactModel(currentUser, artifacts));
    }

    @Override
    public String RenderQuestPage(User currentUser, List<Quest> quests) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/quests.html");

        return template.render(tmi.getQuestModel(currentUser, quests));
    }

    public String RenderQuestTemplatesPage(User currentUser, List<QuestTemplate> questTemplates) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/questsTemplates.html");

        return template.render(tmi.getQuestTemplateModel(currentUser, questTemplates));
    }

    public String RenderEditQuestTemplatesPage(User currentUser, List<QuestTemplate> questTemplates) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/editTemplate.html");

        return template.render(tmi.getQuestTemplateModel(currentUser, questTemplates));
    }

    @Override
    public String rendeAddQuestTemplatesPage(User currentUser) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/questTemplateAdd.html");

        return template.render(tmi.getAddQuestTemplateModel(currentUser));
    }

    @Override
    public String renderAddClassTemplatesPage(User currentUser) {
        TemplateModelInterface tmi = new TemplateModelHandler();

        // get a template file
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/classAdd.html");

        return template.render(tmi.getAddClassModel(currentUser));
    }


}