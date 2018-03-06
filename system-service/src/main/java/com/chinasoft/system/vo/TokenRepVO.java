package com.chinasoft.system.vo;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
public class TokenRepVO implements java.io.Serializable {
    private Token token;
    private String tokenString;

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public TokenRepVO() {
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    private class Token implements java.io.Serializable{
        private String expires_at;
        private String issued_at;
        private User user;
        private Catalog[] catalog;
        private Role[] roles;
        private Project project;

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public Token() {
        }

        public Role[] getRoles() {
            return roles;
        }

        public void setRoles(Role[] roles) {
            this.roles = roles;
        }

        public String getExpires_at() {
            return expires_at;
        }

        public void setExpires_at(String expires_at) {
            this.expires_at = expires_at;
        }

        public String getIssued_at() {
            return issued_at;
        }

        public void setIssued_at(String issued_at) {
            this.issued_at = issued_at;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Catalog[] getCatalog() {
            return catalog;
        }

        public void setCatalog(Catalog[] catalog) {
            this.catalog = catalog;
        }

        private class Catalog implements java.io.Serializable{
            private String id;
            private String type; //目录类型 如是存储 ，服务器
            private String name;
            private Endpoint[] endpoints;

            public Catalog() {
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Endpoint[] getEndpoints() {
                return endpoints;
            }

            public void setEndpoints(Endpoint[] endpoints) {
                this.endpoints = endpoints;
            }

            private class Endpoint implements java.io.Serializable {
                private String url;
                private String region;
                private String region_id;
                @JsonProperty("interface")
                private String inf;
                private String id;

                public Endpoint() {
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getRegion() {
                    return region;
                }

                public void setRegion(String region) {
                    this.region = region;
                }

                public String getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(String region_id) {
                    this.region_id = region_id;
                }

                public String getInf() {
                    return inf;
                }

                public void setInf(String inf) {
                    this.inf = inf;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        private class Role implements java.io.Serializable{
            private String id ;
            private String name;

            public Role() {
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        private class Project implements java.io.Serializable{
            private String name;
            private String id;
            private Domain domain;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Domain getDomain() {
                return domain;
            }

            public void setDomain(Domain domain) {
                this.domain = domain;
            }
        }
    }
}
