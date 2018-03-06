package com.chinasoft.system.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
@JsonIgnoreProperties(ignoreUnknown = true)//用于忽略请求中不存在的属性
//@JsonProperty("value") 用于把原有的属性名称序列化为其他名称如可以把scope序列化为value ，此注解放在属性上
public class TokenReqVO implements java.io.Serializable{
    private Auth auth;
    /**
     * Created by VerRan.Liu on 2017/9/30.
     */
    private class Auth implements java.io.Serializable {
        private Identity identity;
        private Scope scope;

        public Auth() {
        }

        /**
         * Created by VerRan.Liu on 2017/9/30.
         */
        private class Identity implements java.io.Serializable {
            private String[] methods;

            private Password password;

            public Identity() {
            }

            /**
             * Created by VerRan.Liu on 2017/9/30.
             */
            private class Password implements java.io.Serializable {

                private User user;

                public Password() {
                }

                public User getUser() {
                    return user;
                }

                public void setUser(User user) {
                    this.user = user;
                }


            }


            public Password getPassword() {
                return password;
            }

            public void setPassword(Password password) {
                this.password = password;
            }

            public String[] getMethods() {
                return methods;
            }

            public void setMethods(String[] methods) {
                this.methods = methods;
            }
        }
        /**
         * Created by VerRan.Liu on 2017/9/30.
         */
        private class Scope implements java.io.Serializable{
            private Project project;

            public Scope() {
            }

            public Project getProject() {
                return project;
            }

            public void setProject(Project project) {
                this.project = project;
            }

            private class Project {
                public Project() {
                }

                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public Identity getIdentity() {
            return identity;
        }

        public void setIdentity(Identity identity) {
            this.identity = identity;
        }

        public Scope getScope() {
            return scope;
        }

        public void setScope(Scope scope) {
            this.scope = scope;
        }
    }
    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
}
