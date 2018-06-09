import {Component, OnInit} from '@angular/core';
import {PersonService} from './person.service';
import {Observable} from 'rxjs';
import {Person} from './Person';


@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {
  people$: Observable<Person>;

  constructor(private service: PersonService) {
  }

  ngOnInit() {
    this.people$ = this.service.getAll();
  }
}
