import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'client';
  value;

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    $(document).ready(function (e) {

    });
    this.http.get('http://localhost:8080/category/get/').subscribe(value => this.value = value[0]['name']);
  }
}
