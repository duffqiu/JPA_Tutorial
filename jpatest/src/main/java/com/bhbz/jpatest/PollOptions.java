/**
 * 
 */
package com.bhbz.jpatest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author egecqiu
 * 
 */

/*
 * -- Table: polloption
 * 
 * -- DROP TABLE polloption;
 * 
 * CREATE TABLE polloption ( id integer NOT NULL, topic_id integer, votes
 * integer, displayorder integer, option character varying(80), CONSTRAINT
 * polloption_pkey PRIMARY KEY (id), CONSTRAINT fk2ea200f47cb56325 FOREIGN KEY
 * (topic_id) REFERENCES topic (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE
 * NO ACTION, CONSTRAINT polloption_topic_id_fkey FOREIGN KEY (topic_id)
 * REFERENCES topic (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION )
 * WITH ( OIDS=FALSE ); ALTER TABLE polloption OWNER TO duff;
 * 
 * -- Index: polloption_topic_id_idx
 * 
 * -- DROP INDEX polloption_topic_id_idx;
 * 
 * CREATE INDEX polloption_topic_id_idx ON polloption USING btree (topic_id);
 */
@Entity(name = "POLLOPTION")
public class PollOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "OPTION")
    private String option_item;

    @ManyToOne
    @JoinColumn(name = "TOPIC_ID", nullable = false)
    private PollTopic pollTopic;

    @Column(name = "DISPLAYORDER")
    private int displayOrder;

    protected PollOptions() {

    }

    public PollOptions(String option_item, int displayOrder) {
	this.option_item = option_item;
	this.displayOrder = displayOrder;
    }

    public PollTopic getPollTopic() {
	return pollTopic;
    }

    public void setPollTopic(PollTopic pollTopic) {
	this.pollTopic = pollTopic;
    }

    @Override
    public String toString() {
	// Note: don't print pollTopic since pollTopic will print options, that
	// will cause stack full
	return "PollOptions [id=" + id + ", option_item=" + option_item
		+ ", displayOrder=" + displayOrder + "]";
    }

    /**
     * @return the option_item
     */
    public String getOption_item() {
	return option_item;
    }

    /**
     * @param option_item
     *            the option_item to set
     */
    public void setOption_item(String option_item) {
	this.option_item = option_item;
    }

}
