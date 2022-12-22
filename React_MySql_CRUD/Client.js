import axios from 'axios';
import React, { Component } from 'react';

class Client extends Component {
  constructor(props) {
    super(props);
    this.state = { member: [], name: '', age: '', mid: '' };
  }

  f10 = (key) => {

    switch (key) {
      case 'select':
        axios.get('/tiger/list', {})
          .then((res) => {
            console.log(res.data);
            this.setState({ test: res.data });
          }); break;

      case 'insert':
        axios.post('/tiger/add', {
          name: this.state.name,
          password: this.state.password,
        })
          .then((res) => {
            console.log('insert 확인');
          }); break;


      case 'update':
        axios.post('/tiger/update', {
          mid: this.state.mid,
          name: this.state.name,
          password: this.state.password,
        })
          .then((res) => {
            console.log('update 확인');
          }); break;

      case 'delete':
        axios.post('/tiger/delete', {
          name: this.state.name,
        })
          .then((res) => {
            console.log('delete 확인');
          }); break;

      default:
    }
  }
  render() {
    return (
      <div>
        <button onClick={() => { this.f10('select') }}>조회</button><br />
        <h3>추가</h3>
        <form>
          name : <input onChange={(e) => { this.setState({ name: e.target.value }) }} /> <br />
          password : <input onChange={(e) => { this.setState({ password: e.target.value }) }} /> <br />
          <input type='submit' onClick={() => { this.f10('insert') }} value='추가' />
        </form>

        <h3>password 수정</h3>
        <form>
          id : <input onChange={(e) => { this.setState({ mid: e.target.value }) }} /><br />
          name : <input onChange={(e) => { this.setState({ name: e.target.value }) }} /><br />
          password : <input onChange={(e) => { this.setState({ password: e.target.value }) }} /><br />
          <input type='submit' onClick={() => { this.f10('update') }} value='수정' />
        </form>

        <h3>삭제</h3>
        <form>
          name : <input onChange={(e) => { this.setState({ name: e.target.value }) }} /><br />
          <input type='submit' onClick={() => { this.f10('delete') }} value='삭제' />
        </form>



      </div>
    );
  }
}

export default Client;
