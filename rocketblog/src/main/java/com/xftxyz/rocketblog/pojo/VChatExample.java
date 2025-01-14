package com.xftxyz.rocketblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VChatExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public VChatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andChatIdIsNull() {
            addCriterion("chat_id is null");
            return (Criteria) this;
        }

        public Criteria andChatIdIsNotNull() {
            addCriterion("chat_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatIdEqualTo(Long value) {
            addCriterion("chat_id =", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotEqualTo(Long value) {
            addCriterion("chat_id <>", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdGreaterThan(Long value) {
            addCriterion("chat_id >", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chat_id >=", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdLessThan(Long value) {
            addCriterion("chat_id <", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdLessThanOrEqualTo(Long value) {
            addCriterion("chat_id <=", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdIn(List<Long> values) {
            addCriterion("chat_id in", values, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotIn(List<Long> values) {
            addCriterion("chat_id not in", values, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdBetween(Long value1, Long value2) {
            addCriterion("chat_id between", value1, value2, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotBetween(Long value1, Long value2) {
            addCriterion("chat_id not between", value1, value2, "chatId");
            return (Criteria) this;
        }

        public Criteria andUseridFromIsNull() {
            addCriterion("userid_from is null");
            return (Criteria) this;
        }

        public Criteria andUseridFromIsNotNull() {
            addCriterion("userid_from is not null");
            return (Criteria) this;
        }

        public Criteria andUseridFromEqualTo(Long value) {
            addCriterion("userid_from =", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromNotEqualTo(Long value) {
            addCriterion("userid_from <>", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromGreaterThan(Long value) {
            addCriterion("userid_from >", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromGreaterThanOrEqualTo(Long value) {
            addCriterion("userid_from >=", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromLessThan(Long value) {
            addCriterion("userid_from <", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromLessThanOrEqualTo(Long value) {
            addCriterion("userid_from <=", value, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromIn(List<Long> values) {
            addCriterion("userid_from in", values, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromNotIn(List<Long> values) {
            addCriterion("userid_from not in", values, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromBetween(Long value1, Long value2) {
            addCriterion("userid_from between", value1, value2, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridFromNotBetween(Long value1, Long value2) {
            addCriterion("userid_from not between", value1, value2, "useridFrom");
            return (Criteria) this;
        }

        public Criteria andUseridToIsNull() {
            addCriterion("userid_to is null");
            return (Criteria) this;
        }

        public Criteria andUseridToIsNotNull() {
            addCriterion("userid_to is not null");
            return (Criteria) this;
        }

        public Criteria andUseridToEqualTo(Long value) {
            addCriterion("userid_to =", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToNotEqualTo(Long value) {
            addCriterion("userid_to <>", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToGreaterThan(Long value) {
            addCriterion("userid_to >", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToGreaterThanOrEqualTo(Long value) {
            addCriterion("userid_to >=", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToLessThan(Long value) {
            addCriterion("userid_to <", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToLessThanOrEqualTo(Long value) {
            addCriterion("userid_to <=", value, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToIn(List<Long> values) {
            addCriterion("userid_to in", values, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToNotIn(List<Long> values) {
            addCriterion("userid_to not in", values, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToBetween(Long value1, Long value2) {
            addCriterion("userid_to between", value1, value2, "useridTo");
            return (Criteria) this;
        }

        public Criteria andUseridToNotBetween(Long value1, Long value2) {
            addCriterion("userid_to not between", value1, value2, "useridTo");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("message_content is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("message_content is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("message_content =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("message_content <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("message_content >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("message_content >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("message_content <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("message_content <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("message_content like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("message_content not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("message_content in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("message_content not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("message_content between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("message_content not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIsNull() {
            addCriterion("from_username is null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIsNotNull() {
            addCriterion("from_username is not null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameEqualTo(String value) {
            addCriterion("from_username =", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotEqualTo(String value) {
            addCriterion("from_username <>", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThan(String value) {
            addCriterion("from_username >", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("from_username >=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThan(String value) {
            addCriterion("from_username <", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThanOrEqualTo(String value) {
            addCriterion("from_username <=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLike(String value) {
            addCriterion("from_username like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotLike(String value) {
            addCriterion("from_username not like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIn(List<String> values) {
            addCriterion("from_username in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotIn(List<String> values) {
            addCriterion("from_username not in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameBetween(String value1, String value2) {
            addCriterion("from_username between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotBetween(String value1, String value2) {
            addCriterion("from_username not between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromAvatarIsNull() {
            addCriterion("from_avatar is null");
            return (Criteria) this;
        }

        public Criteria andFromAvatarIsNotNull() {
            addCriterion("from_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andFromAvatarEqualTo(String value) {
            addCriterion("from_avatar =", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarNotEqualTo(String value) {
            addCriterion("from_avatar <>", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarGreaterThan(String value) {
            addCriterion("from_avatar >", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("from_avatar >=", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarLessThan(String value) {
            addCriterion("from_avatar <", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarLessThanOrEqualTo(String value) {
            addCriterion("from_avatar <=", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarLike(String value) {
            addCriterion("from_avatar like", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarNotLike(String value) {
            addCriterion("from_avatar not like", value, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarIn(List<String> values) {
            addCriterion("from_avatar in", values, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarNotIn(List<String> values) {
            addCriterion("from_avatar not in", values, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarBetween(String value1, String value2) {
            addCriterion("from_avatar between", value1, value2, "fromAvatar");
            return (Criteria) this;
        }

        public Criteria andFromAvatarNotBetween(String value1, String value2) {
            addCriterion("from_avatar not between", value1, value2, "fromAvatar");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table v_chat
     *
     * @mbg.generated do_not_delete_during_merge Sun Apr 02 13:00:30 CST 2023
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table v_chat
     *
     * @mbg.generated Sun Apr 02 13:00:30 CST 2023
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}