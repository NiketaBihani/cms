package com.hmh.automation.tools;

import net.thucydides.core.annotations.Feature;

public class HMHApplication {

    @Feature
    public class Login {
        public class LoginIntoShare {
        }
    }

    @Feature
    public class Setup {
    	
    	public class CreateSite {	
    	}
    	
    	public class CreateFolder {	
    	}
    	
    	public class AddAspects {	
    	}
    	
    }
    
    
    @Feature
    public class Authentication {
        public class CreateSite {
        }

        public class CreateUser {
        }

        public class CreateUserForTests {
        }

        public class DeleteUser {
        }

        public class DeleteSite {
        }
    }

    @Feature
    public class Commenting {
        public class AddNewComment {
        }
    }

    @Feature
    public class VersionControl {
        public class UploadNewVersion {
        }

        public class DocumentDetailsNewVersionUpload {
        }
    }

   
    
    @Feature
    public class Groups {
    }

    @Feature
    public class Categories {
    }

    @Feature
    public class Tagging {
        public class AddTag {
        }

        public class SearchTags {
        }
    }

    @Feature
    public class ManageRoles {
        public class Roles {
        }
    }

    @Feature
    public class Program {
    	public class MetaData {
		}
    }

    @Feature
    public class ProductSet {
    	public class MetaData {
		}
    }
    
    @Feature
    public class ProductObject {
    	public class MetaData {
		}
    }

    @Feature
    public class Asset {
		public class MetaData {
		    		
		    	}
    }

    @Feature
    public class LearningBundle {
    	public class MetaData {
		}
    }

    @Feature
    public class LearningObject {
		public class MetaData {
		}
    }

    @Feature
    public class CustomizeDashboard {
        public class Dashlets {
        }    
    }

    @Feature
    public class SequenceBundle {
        public class EditSequence {
        }
		public class MetaData {   		
		}
    }

    @Feature
    public class StructuralAndContentObjects {
        public class DeleteStructuralOrContentObject {
        }
    }

    @Feature
    public class ObjectOperations {
        public class CopyObject {
        }

        public class EditProperties {
        }

        public class ChangeType {
        }
    }

    @Feature
    public class ZIP {
    	public class ZIPWithManifest {
		}
    	public class ZIPWithOutManifest {
		}

    }

    @Feature
    public class References {
    }

    @Feature
    public class Annotaions {

    }

    @Feature
    public class Correlations {
    }

    @Feature
    public class DataList {
    }

    @Feature
    public class Associations {
    }

    @Feature
    public class Search {
        public class AdvancedSearch {
        }

        public class QuickSearch {
        }
        
        public class FacettedSearch {  
        }
        
    }
    
    @Feature
    public class CompositeLearningObject {
    }
    
    @Feature
    public class Habitat {
    	
    	  public class EditSequence {
          }
    	  
    	  public class PushToHabitat {
          }
    	  
    	  public class PullFromHabitat {
          }
    }
    
    @Feature
    public class EditSequence {
    	
    }
    
    @Feature
    public class DeleteTestSite {
    }
    
    @Feature
    public class Publishing {
    	
    	public class PublishToQA {
		}
    	
    	public class PublishToDraft {
		}
    }
    
    @Feature
    public class ProgramSupportFolder {
        public class ReferProductSet {
        }
    }   
 
    //Added by 1CMS QA for SiteMembers Requirements
    @Feature
    public class SiteMembers {
    	
        public class SiteGroups {
        }    
    }

    
}
