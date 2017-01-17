package Entry;

import java.util.List;


public class ListEntity {

    private EntityEntity entity;

    public EntityEntity getEntity() {
        return entity;
    }

    public void setEntity(EntityEntity entity) {
        this.entity = entity;
    }



    public static class EntityEntity {

        private List<List<EliminationListEntity>> eliminationList;

        public List<List<EliminationListEntity>> getEliminationList() {
            return eliminationList;
        }

        public void setEliminationList(List<List<EliminationListEntity>> eliminationList) {
            this.eliminationList = eliminationList;
        }

        public static class EliminationListEntity {

            private MemberEntity member;

            public MemberEntity getMember() {
                return member;
            }

            public void setMember(MemberEntity member) {
                this.member = member;
            }

            public int smallscore;

            public static class MemberEntity {
                private String name;
                private int score;
                private String teammateName;


                public String getTeammateName() {
                    return teammateName;
                }

                public void setTeammateName(String teammateName) {
                    this.teammateName = teammateName;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }


                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }



            }
        }
    }
}
