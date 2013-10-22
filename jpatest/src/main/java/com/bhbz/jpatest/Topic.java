/**
 * 
 */
package com.bhbz.jpatest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author egecqiu
 * 
 */

/*
CREATE TABLE topic
(
  id integer NOT NULL,
  title character varying,
  "time" timestamp with time zone,
  views integer,
  type integer,
  multiple integer,
  max_choice integer,
  CONSTRAINT topic_pkey PRIMARY KEY (id)
);
 * */
@Entity(name = "TOPIC")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@DiscriminatorValue(value = "1")
public class Topic {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topicTime;

    @Column(name = "VIEWS")
    private int views;

    @Transient
    private int type = 1;

    protected Topic() {

    }

    /**
     * @param title
     * @param time
     * @param views
     */
    public Topic(String title, Date time, int views) {
	this.title = title;
	this.topicTime = time;
	this.views = views;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Topic [id=" + id + ", title=" + title + ", topicTime="
		+ topicTime + ", views=" + views + ", type=" + type + "]";
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

}
