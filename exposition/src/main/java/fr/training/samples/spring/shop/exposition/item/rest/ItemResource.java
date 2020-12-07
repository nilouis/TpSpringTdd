package fr.training.samples.spring.shop.exposition.item.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.training.samples.spring.shop.application.item.ItemService;
import fr.training.samples.spring.shop.domain.item.Item;

@RestController
@RequestMapping("/api")
public class ItemResource {

	private final ItemService itemService;

	private final ItemMapper itemMapper;

	/**
	 * Constructor for Bean injection
	 */
	public ItemResource(final ItemService itemService, final ItemMapper itemMapper) {
		this.itemService = itemService;
		this.itemMapper = itemMapper;
	}

	@GetMapping(value = "/items", produces = { "application/json" })
	public List<ItemDto> getAllItemsUsingGet() {

		final List<Item> items = itemService.getAllItems();
		return itemMapper.mapToDtoList(items);

	}

	@GetMapping(value = "/items/{id}", produces = { "application/json" })
	public ItemDto getItemUsingGet(@PathVariable final String id) {

		final Item item = itemService.getOneItemByID(id);
		return itemMapper.mapToDto(item);

	}

	@PostMapping(value = "/items", produces = { "application/json" })
	public ResponseEntity<URI> addItemUsingPost(@Valid @RequestBody final ItemLightDto itemDto) {

		final Item item = itemMapper.mapToEntity(itemDto);
		itemService.addItem(item);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}