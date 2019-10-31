package com.hmh.automation.tools;

import net.thucydides.core.annotations.Feature;

public class Application {

    @Feature
    public class Login {
        public class LoginIntoShare {}
    }
    
    @Feature
    public class Authentication {
    	public class CreateSite {}
    	public class CreateUser {}
    	public class DeleteUser {}
    	public class DeleteSite {}
    }
    
    @Feature
    public class Commenting {
    	public class AddNewComment {}
    }
        
    @Feature
    public class VersionControl {
    	public class UploadNewVersion {}
    	public class DocumentDetailsNewVersionUpload {}
    }
    
    @Feature
    public class Tagging {
    	public class AddTag {}
    	public class SearchTags {}
    }
}
