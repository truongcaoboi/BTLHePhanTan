package model;

public class Card {
	private String _id;
	private String _uid;
	private String _dateCreate;
	private String _status;
	private float _balance;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_uid() {
		return _uid;
	}
	public void set_uid(String _uid) {
		this._uid = _uid;
	}
	public String get_dateCreate() {
		return _dateCreate;
	}
	public void set_dateCreate(String _dateCreate) {
		this._dateCreate = _dateCreate;
	}
	public String get_status() {
		return _status;
	}
	public void set_status(String _status) {
		this._status = _status;
	}
	public float get_balance() {
		return _balance;
	}
	public void set_balance(float _balance) {
		this._balance = _balance;
	}
	
}
